<?php

namespace App\Controller;

use App\Repository\BlogpostRepository;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class BlogpostController extends AbstractController
{
    #[Route('/blogpost', name: 'blogpost')]
    public function index(
        BlogpostRepository $blogpostRepository,
        PaginatorInterface $paginator,
        \Symfony\Component\HttpFoundation\Request $request
    ): Response
    {
        $data = $blogpostRepository->findAll();
        $blogposts = $paginator->paginate(
            $data,
            $request->query->getInt('page', 1),
            6
        );

        return $this->render('blogpost/index.html.twig', [
            'blogposts' => $blogposts,
        ]);
    }
}
