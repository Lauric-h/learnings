<template>
    <div class="flex items-center">
        <input
        @click="$emit('filter-read')"
        type="checkbox"
        id="checkbox"
        v-model="checkbox"
        >
        <label class="ml-3" for="checkbox">
            Non lus uniquement
        </label>

    </div>
</template>

<script>

export default {
    props: {
        checkbox: Boolean
    },
}
</script>
