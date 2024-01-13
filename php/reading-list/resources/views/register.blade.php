<x-layout>
    <div class="flex flex-col items-center flex-1 h-full justify-center px-4 sm:px-0">
        <div class="flex rounded-lg shadow-lg w-full sm:w-3/4 lg:w-1/2 bg-white sm:mx-0" style="height: 500px">
            <div class="hidden md:block md:w-1/2 rounded-r-lg" style="background: url('https://images.unsplash.com/photo-1585779034823-7e9ac8faec70?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80'); background-size: cover; background-position: center center;"></div>
            <div class="flex flex-col w-full md:w-1/2 p-4">
                <div class="flex flex-col flex-1 justify-center mb-8">
                    <h1 class="text-4xl text-center font-thin">Inscription</h1>
                    <div class="w-full mt-4 flex flex-col items-center">
                        @if ($errors->any())
                            @foreach ($errors->all() as $error)
                                <div class="text-red-600">{{ $error }}</div>
                            @endforeach
                        @endif
                        <form class="form-horizontal w-3/4 mx-auto" method="POST" action="/api/register">
                            @csrf
                            <div class="flex flex-col mt-4">
                                <input id="name" type="text" class="flex-grow h-8 px-2 focus:border-blue-500 focus:outline-none border rounded border-grey-400" name="name" value="" placeholder="Nom">
                            </div>
                            <div class="flex flex-col mt-4">
                                <input id="email" type="email" class="flex-grow h-8 px-2 border rounded border-grey-400 focus:border-blue-500 focus:outline-none" name="email" value="" placeholder="Email">
                            </div>
                            <div class="flex flex-col mt-4">
                                <input id="password" type="password" class="flex-grow h-8 px-2 border rounded border-grey-400 focus:border-blue-500 focus:outline-none" name="password" value="" placeholder="Mot de passe">
                            </div>
                            <div class="flex flex-col mt-4">
                                <input id="password_confirmation" type="password" class="flex-grow h-8 px-2 rounded border border-grey-400 focus:border-blue-500 focus:outline-none" name="password_confirmation" required placeholder="Confirmation">
                            </div>
                            <div class="flex flex-col mt-8">
                                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white text-sm font-semibold py-2 px-4 rounded">
                                    Se connecter
                                </button>
                            </div>
                        </form>
                        <div class="mt-6">
                            <p class="text-sm text-center font-thin">J'ai déjà un compte : <a class="text-blue-800 hover:text-red-700" href="{{ route('login') }}">connexion</a> </p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</x-layout>
