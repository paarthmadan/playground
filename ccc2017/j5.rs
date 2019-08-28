use std::{io, cmp, collections::HashMap};

fn main() {
    let mut n = String::new();

    io::stdin().read_line(&mut n)
        .expect("Failed to read n");

    let mut map: HashMap<u16, u32> = HashMap::new();

    let mut line = String::new();

    io::stdin().read_line(&mut line)
        .expect("Failed to read board heights");

    line.trim()
        .split(' ')
        .for_each(|n| increment_board_count(&mut map, str::parse::<u16>(n).unwrap()));

    let mut max_length = 0;
    let mut height_combos = 0;

    for height in 2..=4000 {
        let mut length = 0;
        for &key in map.keys() {
            if key > (height / 2) || key > (height - key) { continue; }
            length += board_length_given_key(&map, key, height - key);
        }
        if length > max_length { 
            max_length = length;
            height_combos = 1;
        } else if length == max_length { height_combos += 1; }
    }
    println!("{} {}", max_length, height_combos);
}

fn increment_board_count(board: &mut HashMap<u16, u32>, key: u16) {
    *board.entry(key).or_insert(0) += 1;
}

fn board_length_given_key(board: &HashMap<u16, u32>, x: u16, y: u16) -> u32 {
    let min = cmp::min(*board.get(&x).unwrap_or(&0), *board.get(&y).unwrap_or(&0));
    if x == y { return min / 2; }
    else { return min; }
}
