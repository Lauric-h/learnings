<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Book extends Model
{
    use HasFactory;

    protected $fillable = [
        'title', 'firstName', 'lastName', 'link', 'note', 'read'
    ];

    /**
     * The users associated with the book
     *
     */
    public function users () {
        return $this->belongsToMany(User::class);
    }
}
