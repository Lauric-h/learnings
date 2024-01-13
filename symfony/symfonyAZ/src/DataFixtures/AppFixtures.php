<?php

namespace App\DataFixtures;

use App\Entity\Blogpost;
use App\Entity\Category;
use App\Entity\Photo;
use App\Entity\User;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;
use Faker\Factory;
use Symfony\Component\PasswordHasher\Hasher\UserPasswordHasherInterface;
use Symfony\Component\Security\Core\User\PasswordAuthenticatedUserInterface;

class AppFixtures extends Fixture
{
    private $encoder;

    public function __construct(UserPasswordHasherInterface $encoder)
    {
        $this->encoder = $encoder;
    }

    public function load(ObjectManager $manager): void
    {
        $faker = Factory::create();

        // Create user
        $user = new User();
        $user->setEmail('test@test.fr')
            ->setFirstname($faker->firstName)
            ->setLastname($faker->lastName)
            ->setAbout($faker->text())
            ->setRoles(['ROLE_PHOTOGRAPHER']);

        $plainPassword = 'password';
        $hashedPassword = $this->encoder->hashPassword($user, $plainPassword);
        $user->setPassword($hashedPassword);

        $manager->persist($user);

        // Add 10 blogposts
        for ($i = 0; $i < 10; $i++) {
            $blogpost = new Blogpost();

            $blogpost->setTitle($faker->words(3, true))
                ->setCreatedAt(\DateTimeImmutable::createFromMutable($faker->dateTimeBetween('-6 month', 'now')))
                ->setContent($faker->text(350))
                ->setSlug($faker->slug(3))
                ->setUser($user);

            $manager->persist($blogpost);
        }

        // Create 5 categories
        for ($j = 0; $j < 5; $j++) {
            $category = new Category();

            $category->setName($faker->words(3, true))
                ->setDescription($faker->words(10, true))
                ->setSlug($faker->slug());

            $manager->persist($category);

            // Create 2 pictures by category
            for ($k = 0; $k < 2; $k++) {
                $photo = new Photo();

                $photo->setName($faker->word(3, true))
                    ->setDescription($faker->text())
                    ->setSlug($faker->slug())
                    ->setDate($faker->dateTimeBetween('-6 month', 'now'))
                    ->setUrlSmall($faker->url())
                    ->setUrlRegular('https://images.unsplash.com/photo-1546519638-68e109498ffc?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1490&q=80')
                    ->setPhotographerUrl($faker->url())
                    ->setLocation($faker->words(3, true))
                    ->setLikes($faker->randomDigit())
                    ->setBlurHash($faker->words(3, true))
                    ->setPhotographer($faker->firstName());

                $manager->persist($photo);
            }
        }

        $manager->flush();
    }
}
