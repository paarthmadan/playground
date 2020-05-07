fn main() {
    assert_eq!(1, fib(1));
    assert_eq!(1, fib(2));
    assert_eq!(2, fib(3));
    assert_eq!(55, fib(10));
}

fn fib(a: u32) -> u32{
    if a == 1 || a == 2 {
        1
    } else {
        fib(a-1) + fib(a-2)
    }
}
