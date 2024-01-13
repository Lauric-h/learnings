<?php

namespace App\Http\Controllers;

use App\Models\User;
use App\Http\Response;
use App\Traits\ApiResponser;
use Illuminate\Http\Request;
use Laravel\Sanctum\HasApiTokens;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Http;

class AuthController extends Controller
{

    use HasApiTokens;

    /**
     * Create a new user
     *
     * @param Request $request
     */
    public function register (Request $request)
    {
        $attr = $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|unique:users,email',
            'password' => 'required|string|min:6|confirmed'
        ]);


        $user = User::create([
            'name' => $attr['name'],
            'email' => $attr['email'],
            'password' => bcrypt($attr['password'])
        ]);

        return response()
            ->redirectToRoute('home')
            ->header('Authorization', 'bearer', $user->createToken('API Token')->plainTextToken)
            ->header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')
            ->header('Access-Control-Allow-Headers','Authorization')
            ->header('Access-Control-Allow-Credentials','true');
    }

    /**
     * Log in user
     *
     * @param Request $request
     * @return void
     */
    public function login (Request $request)
    {
        $attr = $request->validate([
            'email' => 'required|string|email|',
            'password' => 'required|string|min:6'
        ]);

        if (!Auth::attempt($attr)) {
            return back()->withErrors([
                'email' => 'email invalide',
                'password' => 'mot de passe invalide'
            ]);
        }

        if (Auth::user()) {
            $request->session()->regenerate();
            return response()
                ->redirectToRoute('home')
                ->header('Authorization', 'bearer', Auth::user()->createToken('API Token')->plainTextToken)
                ->header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')
                ->header('Access-Control-Allow-Headers','Authorization')
                ->header('Access-Control-Allow-Credentials','true');
        }
    }

    /**
     * Log out user
     *
     * @param Request $request
     * @return void
     */
    public function logout (Request $request)
    {
        Auth::user()->tokens()->delete();
        $request->session()->flush();
        return response()->json([
                'message' => 'logged out',
        ], 200);
    }
}
