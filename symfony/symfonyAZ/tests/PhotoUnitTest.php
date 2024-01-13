<?php

namespace App\Tests;

use App\Entity\Category;
use App\Entity\Photo;
use PHPUnit\Framework\TestCase;
use Symfony\Component\Validator\Constraints\DateTime;

class PhotoUnitTest extends TestCase
{
    public function testIsTrue() {
        $photo = new Photo();
        $date = new \DateTime();
        $category = new Category();

        $photo->setName('name')
            ->setDescription('description')
            ->setSlug('slug')
            ->setBlurHash("true")
            ->setLikes(1)
            ->setLocation("France")
            ->setPhotographer("Michel")
            ->setPhotographerUrl("Michel.fr")
            ->setUrlRegular("Michel.fr")
            ->setUrlSmall("Michel.fr")
            ->setDate($date)
            ->addCategory($category);

        $this->assertTrue($photo->getName() === 'name');
        $this->assertTrue($photo->getDescription() === 'description');
        $this->assertTrue($photo->getSlug() === 'slug');
        $this->assertTrue($photo->getBlurHash() === 'true');
        $this->assertTrue($photo->getLikes() === 1);
        $this->assertTrue($photo->getLocation() === 'France');
        $this->assertTrue($photo->getPhotographer() === 'Michel');
        $this->assertTrue($photo->getPhotographerUrl() === 'Michel.fr');
        $this->assertTrue($photo->getUrlRegular() === 'Michel.fr');
        $this->assertTrue($photo->getUrlSmall() === 'Michel.fr');
        $this->assertTrue($photo->getDate() === $date);
        $this->assertContains($category, $photo->getCategory());
    }

    public function testIsFalse() {
        $photo = new Photo();
        $date = new \DateTime();
        $category = new Category();

        $photo->setName('name')
            ->setDescription('description')
            ->setSlug('slug')
            ->setBlurHash("true")
            ->setLikes(1)
            ->setLocation("France")
            ->setPhotographer("Michel")
            ->setPhotographerUrl("Michel.fr")
            ->setUrlRegular("Michel.fr")
            ->setUrlSmall("Michel.fr")
            ->setDate($date)
            ->addCategory($category);

        $this->assertFalse($photo->getName() === 'false');
        $this->assertFalse($photo->getDescription() === 'false');
        $this->assertFalse($photo->getSlug() === 'false');
        $this->assertFalse($photo->getBlurHash() === 'false');
        $this->assertFalse($photo->getLikes() === 2);
        $this->assertFalse($photo->getLocation() === 'false');
        $this->assertFalse($photo->getPhotographer() === 'false');
        $this->assertFalse($photo->getPhotographerUrl() === 'false.fr');
        $this->assertFalse($photo->getUrlRegular() === 'false.fr');
        $this->assertFalse($photo->getUrlSmall() === 'false.fr');
        $this->assertFalse($photo->getDate() === new DateTime());
        $this->assertNotContains(new Category(), $photo->getCategory());
    }

    public function testIsEmpty() {
        $photo = new Photo();

        $this->assertEmpty($photo->getName());
        $this->assertEmpty($photo->getDescription());
        $this->assertEmpty($photo->getSlug());
        $this->assertEmpty($photo->getBlurHash());
        $this->assertEmpty($photo->getLikes());
        $this->assertEmpty($photo->getLocation());
        $this->assertEmpty($photo->getPhotographer());
        $this->assertEmpty($photo->getPhotographerUrl());
        $this->assertEmpty($photo->getUrlRegular());
        $this->assertEmpty($photo->getUrlSmall());
        $this->assertEmpty($photo->getDate());
        $this->assertEmpty($photo->getCategory());
    }
}
