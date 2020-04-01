#[derive(Copy, Clone, Debug)]
struct Entry {
    key: u32,
    value: u32,
}

impl Entry {
    fn new(key: u32, value: u32) -> Entry {
        Entry { key, value }
    }
}

struct Heap {
    list: Vec<Entry>,
}

impl Heap {
    fn build_from_list(list: Vec<u32>) -> Heap {
        let n = list.len();

        let list = list.into_iter().map(|el| Entry::new(el, el)).collect();
        let mut heap = Heap { list };

        for pos in (1..=(n / 2)).rev() {
            heap.downheap(pos);
        }

        heap
    }

    fn new() -> Self {
        Heap { list: Vec::new() }
    }

    fn is_root(pos: usize) -> bool {
        pos == 1
    }

    fn swap(&mut self, a: usize, b: usize) {
        let temp = self.list[a - 1];
        self.list[a - 1] = self.list[b - 1];
        self.list[b - 1] = temp;
    }

    fn get_priority(&self, pos: usize) -> Option<u32> {
        match self.list.get(pos - 1) {
            Some(entry) => Some(entry.key),
            None => None,
        }
    }

    // Pre: Children are max-heaps
    // Restore heap-property by ensuring priority of current node is less than that of above
    fn upheap(&mut self, pos: usize) {
        if Heap::is_root(pos)
            || self.get_priority(pos).unwrap() < self.get_priority(pos / 2).unwrap()
        {
            return;
        } else {
            self.swap(pos, pos / 2);
            self.upheap(pos / 2);
        }
    }

    pub fn insert(&mut self, entry: Entry) {
        self.list.push(entry);
        self.upheap(self.list.len());
    }

    pub fn max(&self) -> Option<&Entry> {
        self.list.get(0)
    }

    // Pre: Children are max-heaps
    // Swap root downwards until it's greater than both of it's children or it becomes a leaf
    fn downheap(&mut self, pos: usize) {
        let left_child = pos * 2;
        let right_child = (pos * 2) + 1;
        let current_priority = self.get_priority(pos).unwrap();

        let mut restored = true;
        let mut new_pos = left_child;

        if let Some(left) = self.get_priority(left_child) {
            restored = if let Some(right) = self.get_priority(right_child) {
                if right > left {
                    new_pos = right_child;
                }
                current_priority >= right && current_priority >= left
            } else {
                current_priority >= left
            }
        }

        if !restored {
            self.swap(pos, new_pos);
            self.downheap(new_pos);
        }
    }

    pub fn remove_max(&mut self) -> Option<Entry> {
        if self.list.len() <= 1 {
            return self.list.pop();
        }

        self.swap(1, self.list.len());
        let max = self.list.pop();
        self.downheap(1);

        max
    }
}

struct PriorityQueue {
    heap: Heap,
}

impl PriorityQueue {
    pub fn new() -> Self {
        PriorityQueue { heap: Heap::new() }
    }

    pub fn insert(&mut self, entry: Entry) {
        self.heap.insert(entry);
    }

    pub fn max(&self) -> Option<&Entry> {
        self.heap.max()
    }

    pub fn remove_max(&mut self) -> Option<Entry> {
        self.heap.remove_max()
    }

    pub fn sort(list: Vec<u32>) -> Vec<u32> {
        let mut pq = PriorityQueue {
            heap: Heap::build_from_list(list),
        };

        let mut sorted: Vec<u32> = Vec::new();
        while let Some(x) = pq.remove_max() {
            sorted.push(x.value);
        }

        sorted
    }
}

fn main() {
    let mut priority_queue = PriorityQueue::new();

    priority_queue.insert(Entry::new(3, 2));
    priority_queue.insert(Entry::new(2, 3));
    priority_queue.insert(Entry::new(1, 10));
    priority_queue.insert(Entry::new(5, 53));

    assert!(priority_queue.max().unwrap().value == 53);

    loop {
        match priority_queue.remove_max() {
            Some(entry) => println!("{}", entry.value),
            None => break,
        }
    }

    for x in PriorityQueue::sort(vec![10, 12, 1, 5, 7, 9, 11, 15, 32, 1006]) {
        print!("{} ", x);
    }
    println!();
}
