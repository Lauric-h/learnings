<template>
    <header class="flex justify-between items-center flex-col lg:flex-row w-full">
        <Button
        @btn-click="$emit('logout')"
        :text="'Se déconnecter'"
        :color="'#f05454'"
        :type="'fas fa-sign-out-alt text-white'"
        />
        <h1 class="tracking-wide text-gray-600 uppercase text-2xl lg:text-4xl leading-normal">Ma liste de lecture</h1>
        <Button
        @btn-click="$emit('toggle-add-book')"
        :text="showAddBook ? 'Fermer' : 'Ajouter un livre'"
        :color="showAddBook ? '#f05454' : '#91c788'"
        :type="showAddBook ? 'text-white fas fa-minus-circle' : 'text-white fas fa-plus-circle'"
        />


    </header>
</template>

<script>
import Button from './Button'

export default {
    name: 'Header',
    props: {
        showAddBook: Boolean
    },
    components: {
        Button
    }
}
</script>
