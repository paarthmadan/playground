use std::{io,collections::BTreeMap};

fn main() {
    let mut line = String::new();
    io::stdin().read_line(&mut line).unwrap();
    let input: Vec<u64> = line.trim().split(" ").map(|x| x.parse().unwrap()).collect();
    let desired = input[1];

    let mut map: BTreeMap<u64, u64> = BTreeMap::new();

    line = String::new();
    io::stdin().read_line(&mut line).unwrap();

    for w in line.trim().split(" ") {
        let key = w.parse().unwrap();
        let count = map.entry(key).or_insert(0);
        *count += 1;
    };

    let (max_height, _) = map.iter().next_back().unwrap();
    let height = pick_height(0, *max_height, *max_height - 1, desired, &map);
    println!("{}", height);
}

fn pick_height(lower_bound: u64, upper_bound: u64, current_height: u64, desired: u64, map: &BTreeMap<u64, u64>) -> u64 {
    let wood_chopped = evaluate_wood_chopped_at_height(&current_height, map);
    if wood_chopped == desired || lower_bound == upper_bound {
        return current_height;
    } else if wood_chopped < desired {
        return pick_height(lower_bound, current_height, (current_height + lower_bound) / 2, desired, map);
    } else if wood_chopped > desired {
        return pick_height(current_height, upper_bound, (upper_bound + current_height) / 2, desired, map);
    } else {
        current_height
    }
}

fn evaluate_wood_chopped_at_height(height: &u64, map: &BTreeMap<u64, u64>) -> u64 {
    let mut sum = 0;
    for (k, v) in map.into_iter().rev() {
        if k < height { break; }
        sum += (k - height) * v;
    }
    sum
}
