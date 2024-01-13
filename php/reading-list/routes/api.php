<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\BookController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

// Route::middleware('auth:api')->get('/user', function (Request $request) {
//     return $request->user();
// });

Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);
Route::get('/logout', [AuthController::class, 'logout'])->middleware(['auth:sanctum']);

Route::group(['middleware' => ['auth:sanctum'], 'prefix' => 'books'], function() {
    Route::get('/', [BookController::class, 'index']);
    Route::get('/{book}', [BookController::class, 'show']);
    Route::post('/', [BookController::class, 'store']);
    Route::delete('/{book}', [BookController::class, 'destroy']);
    Route::put('/{book}', [BookController::class, 'update']);
});

