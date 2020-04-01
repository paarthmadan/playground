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
        let restored = match (
            self.get_priority(left_child),
            self.get_priority(right_child),
        ) {
            (Some(left), Some(right)) => current_priority >= left && current_priority >= right,
            (Some(left), None) => current_priority >= left,
            (None, None) => true,
            _ => unreachable! {},
        };

        if !restored {
            self.swap(pos, left_child);
            self.downheap(left_child);
        }
    }

    pub fn remove_max(&mut self) -> Option<Entry> {
        if self.list.len() <= 1 { return self.list.pop(); }

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
}
