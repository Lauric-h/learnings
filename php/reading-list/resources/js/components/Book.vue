<template>
    <tr :class="['border-b', 'border-gray-200', 'hover:bg-gray-100', book.read ? 'read' : '', 'w-full']">
        <td
        class="py-1 lg:py-3 px-6 text-left whitespace-nowrap"
        @click="$emit('toggle-read', book.id)"
        >
        <i :class="['fas',
         'fa-check-circle',
         'cursor-pointer',
         'transform',
         book.read ? 'text-green-600 hover:text-gray-700-600' : 'text-gray-700 hover:text-green-600',
         'hover:scale-110']"
        ></i>
        </td>
        <td class=" text-left whitespace-nowrap">{{ book.title }}</td>
        <td class=" text-left whitespace-nowrap">{{ book.firstName }}</td>
        <td class=" text-left whitespace-nowrap">{{ book.lastName }}</td>
        <td class=" text-left whitespace-nowrap">
            <div class="flex item-center justify-center">
                <div class="lg:w-4 mr-2"><a :href="book.link" target="_blank"><i class="fas fa-search text-gray-700 transform cursor-pointer hover:scale-110"></i></a></div>
                <div
                class="lg:w-4 mr-2"
                @click="$emit('delete-book', book.id)">
                    <i class="fas fa-trash text-gray-700 hover:text-red-700 cursor-pointer transform hover:scale-110"></i>
                </div>
            </div>
        </td>
    </tr>
</template>

<script>
export default {
    name: 'Book',
    props: {
        book: Object
    },
}
</script>

<style scope>

.read {
    border-left: 5px solid #91c788;
}

</style>
