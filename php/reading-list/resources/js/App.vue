<template>
    <div class="overflow-x-auto h-screen overflow-hidden">
        <div class="relative flex items-center justify-center font-sans">
            <div class="md:w-4/5 w-full flex flex-col items-center justify-start min-h-screen pt-20">
                <Header
                @toggle-add-book="toggleAddBook"
                :showAddBook="showAddBook"
                @logout="logout"
                />
                <AddBook v-show="showAddBook" @add-book="addBook" />
                <Filter
                @filter-read="filterRead"
                />
                <Books
                @toggle-read="toggleRead"
                @delete-book="deleteBook"
                @sort-asc="sortAsc"
                @sort-dsc="sortDsc"
                :books="books"
                />
            </div>
        </div>
    </div>
</template>

<script>
import Books from './components/Books'
import AddBook from './components/AddBook'
import Footer from './components/Footer'
import Header from './components/Header.vue'
import Filter from './components/Filter.vue'

export default {
    name: 'App',
    props: {
        showAddBook: Boolean
    },
    components: {
        Books,
        AddBook,
        Footer,
        Header,
        Filter
    },
    data() {
        return {
            books: [],
            showAddBook: false
        }
    },
    methods: {
       addBook(book) {
           try {
               axios.post('/api/books', book).then(this.fetchBooks())
               this.showAddBook = false;
           } catch (error) {
                return error.response
           }
        },
        toggleRead (id) {
            // this.books = this.books.map((book) => book.id === id ? {...book, read: !book.read} : book)
            try {
                let book = this.books.find((book) => book.id === id)
                let read = !book.read

                axios.put(`/api/books/${id}`, {
                    read: read
                }).then(this.fetchBooks())
            } catch (error) {
                return error.response
            }
        },
        deleteBook (id) {
            try {
                axios.delete(`/api/books/${id}`).then(()=> this.fetchBooks())
            } catch (error) {
                return error.response
            }
        },
        toggleAddBook() {
            this.showAddBook = !this.showAddBook
        },
        fetchBooks () {
            try {
                axios.get('/api/books').then(response => {
                    this.books = response.data.data
                })
            } catch (error) {
                return error.response
            }
        },
        logout() {
            try {
                axios.get('/api/logout').then(document.location.href = "/login");
            } catch (error) {
                return error.response
            }
        },
         filterRead() {
            if (checkbox.checked) {
                this.books = this.books.filter(book => !book.read)
            } else {
                this.books = this.fetchBooks()
            }
        },
        sortAsc(type) {
            this.books = this.books.sort((a, b) => a[type] < b[type] ? -1 : 1)
        },
        sortDsc(type) {
            this.books = this.books.sort((a, b) => a[type] > b[type] ? -1 : 1)
        },
    },
    created () {
        this.books = this.fetchBooks()
    },

}
</script>

