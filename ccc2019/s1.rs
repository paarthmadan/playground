use std::io;

fn main() {
    let mut grid: Vec<Vec<u8>> = vec!(vec!(1,2), vec!(3,4));
    let mut input = String::new();
    io::stdin().read_line(&mut input)
        .expect("Failed to read line");
    let input = (input.matches('H').count() % 2, input.matches('V').count() % 2);

    if input.0 == 1 { horizontal_flip(&mut grid); }
    if input.1 == 1 { vertical_flip(&mut grid); }

    print_grid(&grid);
}

fn vertical_flip(grid: &mut Vec<Vec<u8>>) {
    for row in grid {
        let temp = row[0];
        row[0] = row[1];
        row[1] = temp;
    }
}

fn horizontal_flip(grid: &mut Vec<Vec<u8>>) {
    for i in 0..=1 {
        let temp = grid[0][i];
        grid[0][i] = grid[1][i];
        grid[1][i] = temp;
    }
}

fn print_grid(grid: &Vec<Vec<u8>>) {
    for row in grid {
        println!("{} {}", row[0], row[1]);
    }
}

