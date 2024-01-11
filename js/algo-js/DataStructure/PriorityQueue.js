export default class PriorityQueue {
    constructor() {
        this.items = []
    }

    enqueue(node) {
        let contain = false

        for (let i = 0; i < this.items.length; i++) {
            if (this.items[i].priority > node.priority) {
                this.items.splice(i,0, node)
                contain = true
                break
            }
        }
        if (!contain) {
            this.items.push(node)
        }
    }

    dequeue() {
        if (this.isEmpty()) {
            return 'Empty queue'
        }
        return this.items.shift()
    }

    isEmpty() {
        return this.items.length === 0
    }

}
