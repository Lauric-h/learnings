<?php

namespace App\Tests;

use App\Entity\User;
use PHPUnit\Framework\TestCase;

class UserUnitTest extends TestCase
{
    public function testIsTrue() {
        $user = new User();

        $user->setEmail('true@test.com')
            ->setFirstname('Lauric')
            ->setLastname('Lastname')
            ->setAbout('Description');

        $this->assertTrue($user->getEmail() === 'true@test.com');
        $this->assertTrue($user->getFirstname() === 'Lauric');
        $this->assertTrue($user->getLastname() === 'Lastname');
        $this->assertTrue($user->getAbout() === 'Description');
    }

    public function testIsFalse() {
        $user = new User();

        $user->setEmail('true@test.com')
            ->setFirstname('Lauric')
            ->setLastname('Lastname')
            ->setAbout('Description');

        $this->assertFalse($user->getEmail() === 'false@test.com');
        $this->assertFalse($user->getFirstname() === 'false');
        $this->assertFalse($user->getLastname() === 'false');
        $this->assertFalse($user->getAbout() === 'false');
    }

    public function testIsEmpty() {
        $user = new User();

        $this->assertEmpty($user->getEmail());
        $this->assertEmpty($user->getFirstname());
        $this->assertEmpty($user->getLastname());
        $this->assertEmpty($user->getAbout());
    }
}
