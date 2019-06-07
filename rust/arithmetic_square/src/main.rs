use std::io::{self, BufRead};

fn main() {
    test();

    let mut grid: Vec<Vec<Option<i32>>> = Vec::new();
    for _i in 0..3 {
        let reader = io::stdin();
        let numbers: Vec<Option<i32>> = reader
            .lock()
            .lines().next().unwrap().unwrap()
            .split_whitespace()
            .map(|s|
                match s.parse::<i32>() {
                    Ok(i) => Some(i),
                    Err(..) => None,
                }
             )
            .collect();
        grid.push(numbers);
    }

    traverse_grid(&mut grid);
}

fn test() {
    let mut row: Vec<Option<i32>> = vec![Some(1), None, Some(5)];
    let mut row2: Vec<Option<i32>> = vec![None, None, Some(5)];

    assert!(incomplete_count(&row) == 1);
    assert!(incomplete_count(&row2) == 2);
}

fn incomplete_count(trio: &Vec<Option<i32>>) -> u8 {
    let mut count = 0;
    for &i in trio {
        if let None = &i {
            count += 1;
        }
    }
    count
}

