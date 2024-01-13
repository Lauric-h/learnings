<template>
    <form @submit="onSubmit" class="text-gray-700 form-horizontal w-4/5 lg:w-1/3 mx-auto overflow-hidden text-base font-light">
        <div class="flex flex-col mt-4">
            <label class="mb-2" for="title">Titre</label>
            <input class="flex-grow h-8 px-2 focus:border-blue-500 focus:outline-none border rounded border-grey-400" v-model="title" name="title" type="text" placeholder="Titre du livre" required>
        </div>
        <div class="flex flex-col mt-4">
            <label class="mb-2" for="firstName">Prénom</label>
            <input class="flex-grow h-8 px-2 focus:border-blue-500 focus:outline-none border rounded border-grey-400" v-model="firstName" name="firstName" type="text" placeholder="Prénom de l'auteur">
        </div>
        <div class="flex flex-col mt-4">
            <label class="mb-2" for="lastName">Nom</label>
            <input class="flex-grow h-8 px-2 focus:border-blue-500 focus:outline-none border rounded border-grey-400" v-model="lastName" name="lastName" type="text" placeholder="Nom de l'auteur" required>
        </div>
        <div class="flex flex-col mt-4">
            <label class="mb-2" for="link">Lien</label>
            <input class="flex-grow h-8 px-2 focus:border-blue-500 focus:outline-none border rounded border-grey-400" v-model="link" name="link" type="text" placholder="Lien vers le livre">
        </div>
        <div class="flex mt-4 items-center">
            <label for="read">Lu</label>
            <input class="h-4 w-4 text-gray-700 border rounded ml-2" v-model="read" name="read" type="checkbox">
        </div>
        <div class="flex flex-col mt-4">
            <input class="bg-blue-500 hover:bg-blue-700 text-white text-sm font-semibold py-2 px-4 rounded cursor-pointer" type="submit" value="Ajouter" />
        </div>
    </form>
</template>

<script>
export default {
    name: 'AddBook',
    data () {
        return {
            title: '',
            firstName: '',
            lastName: '',
            link: 'http://' + '',
            read: false
        }
    },
    methods: {
        onSubmit (e) {
            e.preventDefault()

            const newBook = {
                title: this.title,
                firstName: this.firstName,
                lastName: this.lastName,
                link: this.link,
                read: this.read
            }

            this.title = '',
            this.firstName = '',
            this.lastName = '',
            this.link = 'http://' + '',
            this.read = false

            this.$emit('add-book', newBook)
        }
    }
}
</script>
