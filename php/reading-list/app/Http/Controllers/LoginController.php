<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LoginController extends Controller
{
    /**
     * Check if useralready logged in
     *
     * @param Request $request
     * @return void
     */
    public function login(Request $request) {
        if (Auth::check()) {
            return redirect()->route('home');
        }
        return view('login');
    }

    /**
     * Check if useralready logged in
     *
     * @param Request $request
     * @return void
     */
    public function register(Request $request) {
        if (Auth::check()) {
            return redirect()->route('home');
        }
        return view('register');
    }
}
