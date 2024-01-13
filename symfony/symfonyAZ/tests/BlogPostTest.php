<?php

namespace App\Tests;

use App\Entity\Blogpost;
use App\Entity\User;
use PHPUnit\Framework\TestCase;

class BlogPostTest extends TestCase
{
    public function testIsTrue() {
        $blogpost = new Blogpost();
        $date = new \DateTimeImmutable();
        $user = new User();

        $blogpost->setTitle('title')
            ->setContent('Content')
            ->setCreatedAt($date)
            ->setSlug('slug')
            ->setUser($user);

        $this->assertTrue($blogpost->getTitle() === 'title');
        $this->assertTrue($blogpost->getContent() === 'Content');
        $this->assertTrue($blogpost->getCreatedAt() === $date);
        $this->assertTrue($blogpost->getSlug() === 'slug');
        $this->assertTrue($blogpost->getUser() === $user);
    }

    public function testIsFalse() {
        $blogpost = new Blogpost();
        $date = new \DateTimeImmutable();
        $user = new User();

        $blogpost->setTitle('title')
            ->setContent('Content')
            ->setCreatedAt($date)
            ->setSlug('slug')
            ->setUser($user);

        $this->assertFalse($blogpost->getTitle() === 'false');
        $this->assertFalse($blogpost->getContent() === 'false');
        $this->assertFalse($blogpost->getCreatedAt() === new \DateTime());
        $this->assertFalse($blogpost->getSlug() === 'false');
        $this->assertFalse($blogpost->getUser() === new User());
    }

    public function testIsEmpty() {
        $blogpost = new Blogpost();

        $this->assertEmpty($blogpost->getTitle());
        $this->assertEmpty($blogpost->getContent());
        $this->assertEmpty($blogpost->getCreatedAt());
        $this->assertEmpty($blogpost->getSlug());
        $this->assertEmpty($blogpost->getCreatedAt());
        $this->assertEmpty($blogpost->getUser());
    }
}
