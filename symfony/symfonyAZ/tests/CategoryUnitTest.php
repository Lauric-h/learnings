<?php

namespace App\Tests;

use App\Entity\Category;
use PHPUnit\Framework\TestCase;

class CategoryUnitTest extends TestCase
{
    public function testIsTrue() {
        $category = new Category();

        $category->setName('true@test.com')
            ->setDescription('description')
            ->setSlug('slug');

        $this->assertTrue($category->getName() === 'true@test.com');
        $this->assertTrue($category->getDescription() === 'description');
        $this->assertTrue($category->getSlug() === 'slug');
    }

    public function testIsFalse() {
        $category = new Category();

        $category->setName('true@test.com')
            ->setDescription('Lauric')
            ->setSlug('Lastname');

        $this->assertFalse($category->getName() === 'false@test.com');
        $this->assertFalse($category->getDescription() === 'false');
        $this->assertFalse($category->getSlug() === 'false');
    }

    public function testIsEmpty() {
        $category = new Category();

        $this->assertEmpty($category->getName());
        $this->assertEmpty($category->getDescription());
        $this->assertEmpty($category->getSlug());
    }
}
