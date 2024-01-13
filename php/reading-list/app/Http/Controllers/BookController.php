<?php

namespace App\Http\Controllers;

use App\Models\Book;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class BookController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $user = User::findOrFail(Auth::user()->id);
        $books = $user->books()->get();

        if (!$books) {
            return response()->json([
                'success' => false,
                'message' => 'no books found'
            ], 404);
        }

        return  response()->json([
            'success' => true,
            'message' => 'books found',
            'data' => $books
        ], 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $user = User::findOrFail(Auth::user()->id);

        $request->validate([
            'title' => 'required',
            'lastName' => 'required'
        ]);

        $book = Book::create($request->all());
        $user->books()->save($book);

        if (!$book) {
            return response()->json([
                'success' => false,
                'message' => 'error adding book'
            ], 404);
        }

        return  response()->json([
            'success' => true,
            'message' => 'book added',
            'data' => $book
        ], 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Book  $book
     * @return \Illuminate\Http\Response
     */
    public function show(Book $book)
    {
        $user = User::findOrFail(Auth::user()->id);

        $foundBook = $user->books()->where('book_id', $book->id)->first();

        if (!$foundBook || !$book) {
            return response()->json([
                'success' => false,
                'message' => 'no book found'
            ], 404);
        }

        return  response()->json([
            'success' => true,
            'message' => 'book found',
            'data' => $foundBook
        ], 200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Book  $book
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Book $book)
    {
        $user = User::findOrFail(Auth::user()->id);

        // $request->validate([
        //     'title' => 'required',
        //     'lastName' => 'required'
        // ]);

        $modifiedBook = $user->books()
                        ->where('book_id', $book->id)
                        ->update($request->all());

        if (!$modifiedBook) {
            return response()->json([
                'success' => 'error updating book'
            ], 500);
        }

        return  response()->json([
            'success' => true,
            'message' => 'book updated successfully',
            'data' => $modifiedBook
        ], 200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Book  $book
     * @return \Illuminate\Http\Response
     */
    public function destroy(Book $book)
    {
        $user = User::findOrFail(Auth::user()->id);
        $deletedBook = $user->books()
                    ->where('book_id', $book->id)
                    ->delete();

        if (!$deletedBook) {
            return response()->json([
                'success' => false,
                'message' => 'error deleting book'
            ], 500);
        }

        return  response()->json([
            'success' => true,
            'message' => 'book deleted successfully',
            'data' => $deletedBook
        ], 200);
    }
}
