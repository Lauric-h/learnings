<?php

namespace App\Controller;

use App\Entity\User;
use App\Repository\UserRepository;
use Doctrine\ORM\NonUniqueResultException;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AboutController extends AbstractController
{
    #[Route('/about', name: 'about')]
    public function index(UserRepository $userRepository): Response
    {
        try {
            $photographer = $userRepository->getPhotographer();
        } catch (NonUniqueResultException $e) {
            $photographer = new User();
        }
        return $this->render('about/index.html.twig', [
            'photographer' => $photographer,
        ]);
    }
}
