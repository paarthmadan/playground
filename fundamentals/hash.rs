use std::fmt;

struct Key(u64);

struct Entry<T> {
    key: Key,
    value: T,
}

impl<T: std::fmt::Display> fmt::Display for Entry<T> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{}: {}", self.key.0, self.value)
    }
}

trait Dictionary<T> {
    fn add(&mut self, entry: Entry<T>) -> Option<Entry<T>>;
    fn contains(&self, key: Key) -> bool;
    fn remove(&mut self, key: Key) -> Option<Entry<T>>;
}

mod chaining {
    use std::fmt;
    use super::{Dictionary, Key, Entry};

    const DEFAULT_SIZE: usize = 0x1 << 7;

    type Link<T> = Option<Box<Node<T>>>;

    struct Node<T> {
        next: Link<T>,
        entry: Entry<T>,
    }

    impl<T: std::fmt::Display> fmt::Display for Node<T> {
        fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            match self.next {
                Some(node) => write!(f, "({}) -> ", self.entry),
                None => write!(f, "({})", self.entry),
            }
        }
    }

    struct Chain<T> {
        head: Link<T>
    }

    impl<T> Chain<T> {
        fn new(node: Node<T>) -> Self {
            Chain {
                head: Some(Box::new(node)),
            }
        }
    }

    impl<T: std::fmt::Display> fmt::Display for Chain<T> {
        fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            match self.head {
                Some(node) => {
                    let mut curr = node;
                    while if let Some(boxed_node) = curr.next {
                        write!(f, "{}", boxed_node);
                        curr = boxed_node.next;
                    };
                    Ok()
                }
                None => write!(f, "{{}}"),
            }
        }
    }

    impl<T> Node<T> {
        fn new(entry: Entry<T>) -> Self {
            Node {
                next: None,
                entry,
            }
        }
    }

    pub struct HashTable<T> {
        table: Vec<Chain<T>>,
        entries: u64,
    }

    impl<T: std::fmt::Display> HashTable<T> {
        fn hash(n: u64, key: &Key) -> usize {
            (key.0 % n) as usize
        }

        pub fn new() -> Self {
            HashTable {
                table: Vec::with_capacity(DEFAULT_SIZE),
                entries: 0,
            }
        }

        pub fn print(&self) {
            for chain in self.table {
                println!("{}", chain)
            }
        }
    }

    
    impl<T> Dictionary<T> for HashTable<T> {
        fn add(&mut self, entry: Entry<T>) -> Option<Entry<T>> {
            let h = HashTable::<T>::hash(self.table.len() as u64, &entry.key);
            match self.table.get_mut(h) {
                None => {
                    self.table[h] = Chain::new(Node::new(entry));
                }
                Some(list) => {
                    let mut curr_link = list.head.take();
                    while let Some(mut boxed_node) = curr_link {
                        curr_link = boxed_node.next.take();
                    };
                    if let Some(mut link) = curr_link {
                        link.next = Some(Box::new(Node::new(entry)));
                    };
                }
            }
            self.entries += 1;
            None
        }

        fn contains(&self, key: Key) -> bool {
            false
        }

        fn remove(&mut self, key: Key) -> Option<Entry<T>> {
            None
        }
    }
}

fn main() {
    let table: chaining::HashTable<u64> = chaining::HashTable::new();
}

