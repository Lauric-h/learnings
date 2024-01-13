<template>
     <div class="p-2 md:w-40 ">
        <div
        :style="{ background: color }"
        class="flex items-center p-2 bg-blue-300 text-gray-800 rounded-lg shadow-sm cursor-pointer hover:bg-indigo-500 hover:text-gray-100"
        >
            <div>
                <i
                :class="type"
                ></i>
                <button
                @click="onClick()"
                class="text-sm font-mediumd ml-2"
                >
                {{ text }}
              </button>
            </div>
        </div>
    </div>

</template>


<script>
export default {
    name: 'Button',
    props: {
        text: String,
        color: String,
        type: String
    },
    methods: {
        onClick() {
            this.$emit('btn-click')
        }
    }
}
</script>
