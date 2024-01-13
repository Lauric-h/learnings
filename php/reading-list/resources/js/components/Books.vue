<template>
    <div class="md:w-full bg-white shadow-md rounded-sm lg:my-6 mb-8">
        <table class="w-full table-auto"  style="width:100%">
            <thead>
                <tr class="bg-gray-200 text-gray-600 uppercase text-base leading-normal sm:text-xs">
                    <td class="lg:py-3 lg:px-6 text-left">
                        Lu
                    </td>
                    <td class="lg:py-3 lg:px-6 text-left">
                        <i class="fas fa-sort-alpha-down-alt cursor-pointer" @click="$emit('sort-dsc', 'title')"></i>
                        Titre
                        <i class="fas fa-sort-alpha-up-alt cursor-pointer" @click="$emit('sort-asc', 'title')"></i>
                    </td>
                    <td class="lg:py-3 lg:px-6 text-left">
                        <i class="fas fa-sort-alpha-down-alt cursor-pointer" @click="$emit('sort-dsc', 'firstName')"></i>
                        Prénom auteur
                        <i class="fas fa-sort-alpha-up-alt cursor-pointer" @click="$emit('sort-asc', 'firstName')"></i>
                    </td>
                    <td class="lg:py-3 lg:px-6 text-left">
                        <i class="fas fa-sort-alpha-down-alt cursor-pointer" @click="$emit('sort-dsc', 'lastName')"></i>
                        Nom auteur
                        <i class="fas fa-sort-alpha-up-alt cursor-pointer" @click="$emit('sort-asc', 'lastName')"></i>
                    </td>
                    <td class="lg:py-3 px-3 lg:px-6 text-center">Actions</td>
                </tr>
            </thead>
            <tbody class="text-gray-600 text-base font-light w-max ">
                <Book
                @toggle-read="$emit('toggle-read', book.id)"
                @delete-book="$emit('delete-book', book.id)"
                v-for="book in books"
                :key="book.id"
                :book="book"
                />
            </tbody>
        </table>
    </div>

</template>

<script>
import Book from './Book'

export default {
    name: 'Books',
    props: {
        books: Array
    },
    components: {
        Book,
    },
    emits: [
        'toggle-read',
        'delete-book',
        'sort-asc',
        'sort-dsc',
    ],
}
</script>
