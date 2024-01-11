import PriorityQueue from "../DataStructure/PriorityQueue.js";

export default function AStar(graph, start, target) {
    const queue = new PriorityQueue()
    queue.enqueue(start)
    let cameFrom = new Map()
    let currentCost = new Map()
    cameFrom[start] = null
    currentCost[start] = 0

    let current, el

    while (!queue.isEmpty()) {
        current = queue.dequeue().v

        if (current === target) {
            console.log('found')
            break
        }
        for (const neighbor in graph.adjacencyList[current]) {
            let newCost = currentCost[current] + graph.adjacencyList[current][neighbor]
            if(neighbor || newCost < currentCost[neighbor]) {
                currentCost[neighbor] = newCost
                let priority = newCost + manhattanHeuristic(target, neighbor)
                el = {
                    v: neighbor.v,
                    distance: priority
                }
                queue.enqueue(el)
                cameFrom[neighbor] = current
            }
        }
    }
    return queue
}

function compareTwoNodes(n1, n2) {
    if (n1.h < n2.h) {
        return 1
    }
    if (n1.h === n2.h) {
        return 0
    }
    return -1
}

function manhattanHeuristic(a, b) {
    return (a.x - b.x) + (a.y - b.y)
}
