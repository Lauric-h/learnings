<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/264c9e1633.js" crossorigin="anonymous"></script>
        <link href="{{ asset('css/app.css') }}" rel="stylesheet">
        <title>Ma liste de lecture</title>

    </head>
    <body class="bg-blue-100 flex flex-col justify-center min-h-screen">
        {{ $slot }}
        <footer class="p-4 tracking-wider text-gray-800 uppercase text-base leading-normal text-center mt-6">
            Coded with <i class="fas fa-book"></i> by <a class="hover:text-white hover:scale-110" href="https://lauric.netlify.app/" target="_blank">Lauric</a> - <a class="hover:scale-110 hover:text-white" href="https://www.linkedin.com/in/lauric/" target="_blank"><i class="fab fa-linkedin-in"></i></a> <a href="https://github.com/Lauric-h" class="hover:scale-110 hover:text-white" target="_blank"><i class="fab fa-github"></i></a>
        </footer>
    </body>

</html>
