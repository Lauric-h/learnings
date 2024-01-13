<?php

namespace App\Controller;

use App\Repository\PhotoRepository;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PhotoController extends AbstractController
{
    #[Route('/photo', name: 'photo')]
    public function index(
        PhotoRepository $photoRepository,
        PaginatorInterface $paginator,
        \Symfony\Component\HttpFoundation\Request $request
    ): Response
    {
        $data = $photoRepository->findAll();
        $photos = $paginator->paginate(
            $data,
            $request->query->getInt('page', 1),
            6
        );

        return $this->render('photo/index.html.twig', [
            'photos' => $photos,
        ]);
    }
}
