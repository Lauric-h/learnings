<?php

namespace App\Tests;

use App\Entity\Blogpost;
use App\Entity\Comment;
use App\Entity\Photo;
use PHPUnit\Framework\TestCase;

class CommentTest extends TestCase
{
    public function testIsTrue() {
        $comment = new Comment();
        $date = new \DateTimeImmutable();
        $blogpost = new Blogpost();
        $photo = new Photo;

        $comment->setEmail('true@test.com')
            ->setAuthor('author')
            ->setCreatedAt($date)
            ->setContent('content')
            ->setPhoto($photo)
            ->setBlogpost($blogpost);

        $this->assertTrue($comment->getEmail() === 'true@test.com');
        $this->assertTrue($comment->getAuthor() === 'author');
        $this->assertTrue($comment->getBlogpost() === $blogpost);
        $this->assertTrue($comment->getCreatedAt() === $date);
        $this->assertTrue($comment->getContent() === 'content');
        $this->assertTrue($comment->getPhoto() === $photo);
    }

    public function testIsFalse() {
        $comment = new Comment();
        $date = new \DateTimeImmutable();
        $blogpost = new Blogpost();
        $photo = new Photo;

        $comment->setEmail('true@test.com')
            ->setAuthor('author')
            ->setCreatedAt($date)
            ->setContent('content')
            ->setPhoto($photo)
            ->setBlogpost($blogpost);

        $this->assertFalse($comment->getEmail() === 'false@test.com');
        $this->assertFalse($comment->getAuthor() === 'false');
        $this->assertFalse($comment->getBlogpost() === 'false');
        $this->assertFalse($comment->getCreatedAt() === new \DateTimeImmutable());
        $this->assertFalse($comment->getContent() === 'false');
        $this->assertFalse($comment->getPhoto() === new Photo());
    }

    public function testIsEmpty() {
        $comment = new Comment();

        $this->assertEmpty($comment->getEmail());
        $this->assertEmpty($comment->getAuthor());
        $this->assertEmpty($comment->getBlogpost());
        $this->assertEmpty($comment->getCreatedAt());
        $this->assertEmpty($comment->getContent());
        $this->assertEmpty($comment->getPhoto());
    }
}
