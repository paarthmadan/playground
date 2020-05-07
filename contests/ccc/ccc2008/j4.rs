use std::collections::VecDeque;
use std::io;

enum Operator {
    Addition,
    Subtraction,
}

enum Expression {
    Atomic(u32),
    Composed(Box<Expression>, Operator, Box<Expression>),
}

impl Expression {
    fn atomic(value: u32) -> Self {
        Expression::Atomic(value)
    }

    fn composed(lhs: Expression, operator: Operator, rhs: Expression) -> Self {
        Expression::Composed(Box::new(lhs), operator, Box::new(rhs))
    }

    fn parse_from_infix(input: String) -> Self {
        let input: Vec<&str> = input.split(" ").collect();
        let mut expression_stack: VecDeque<Expression> = VecDeque::new();
        for t in input.iter().rev() {
            let parse = t.parse::<u32>();
            let expression = if parse.is_ok() {
                Expression::atomic(parse.unwrap())
            } else {
                let operator = match *t {
                    "+" => Operator::Addition,
                    "-" => Operator::Subtraction,
                    _ => unreachable! {},
                };

                let (lhs, rhs) = (expression_stack.pop_front(), expression_stack.pop_front());
                Expression::composed(lhs.unwrap(), operator, rhs.unwrap())
            };
            expression_stack.push_front(expression);
        }
        expression_stack.pop_front().unwrap()
    }

    fn to_postfix(&self) -> String {
        match &self {
            Expression::Atomic(v) => v.to_string(),
            Expression::Composed(lhs, op, rhs) => {
                let op = match op {
                    Operator::Addition => "+",
                    Operator::Subtraction => "-",
                };

                format!("{} {} {}", lhs.to_postfix(), rhs.to_postfix(), op)
            }
        }
    }
}

fn main() {
    loop {
        let mut input = String::new();
        io::stdin()
            .read_line(&mut input)
            .expect("Couldn't read from stdin");

        input = input.trim().to_string();

        if input == "0" {
            break;
        }

        let expression = Expression::parse_from_infix(input);
        println!("{}", expression.to_postfix());
    }
}
