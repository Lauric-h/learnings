<?php

namespace Database\Seeders;

use App\Models\Book;
use Illuminate\Database\Seeder;

class BookSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Book::insert([
            [
                'title' => "Half of a Yellow Sun",
                'firstName' => "Chimamanda",
                'lastName' => "Adichie",
                'link' => "https://dev.to/code2rithik/my-visual-studio-code-setup-483k",
            ],
            [
                'title' => "Encyclopedia of Pseudoscience:",
                'firstName' => "William F.",
                'lastName' => "Williams",
                'link' => "https://dzone.com/articles/stop-coding-start-configuring",
            ],
            [
                'title' => "Things fall apart",
                'firstName' => "Chinua",
                'lastName' => "Achebe",
                'link' => "https://api.daily.dev/r/cuMEh8RHy",
            ],
            [
                'title' => "Tall Tales about the Mind and Brain",
                'firstName' => "Della",
                'lastName' => "Sala",
                'link' => "https://daily.dev/blog/perfect-score-portfolio-flutter-in-5-days-wwdc21-picks-174",
            ],
            [
                'title' => "Anthills of the Savannah",
                'firstName' => "Chinua",
                'lastName' => "Achebe",
                'link' => "https://api.daily.dev/r/_bHSK8BRL",
            ],
            [
                'title' => "Americanah",
                'firstName' => "Chimamanda ",
                'lastName' => "Ngozi Adichie",
                'link' => "https://api.daily.dev/r/R2fb7oFLI",
            ],
        ]);
    }
}
