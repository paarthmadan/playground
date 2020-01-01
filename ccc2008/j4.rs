use std::collections::VecDeque;
use std::io;

struct Expression {
    expression_type: ExpressionType,
}

impl Expression {
    fn atomic(value: u32) -> Self {
        Expression {
            expression_type: ExpressionType::Atomic(value),
        }
    }

    fn composed(lhs: Expression, operator: Operator, rhs: Expression) -> Self {
        Expression {
            expression_type: ExpressionType::Composed(Box::new(lhs), operator, Box::new(rhs)),
        }
    }

    fn parse_from_infix(input: String) -> Self {
        let input: Vec<&str> = input.split(" ").collect();
        let mut expression_stack: VecDeque<Expression> = VecDeque::new();
        for t in input.iter().rev() {
            match t.parse::<u32>() {
                Ok(t) => {
                    expression_stack.push_front(Expression::atomic(t));
                    continue;
                }
                Err(_) => {}
            }
            let operator = match *t {
                "+" => Operator::Addition,
                "-" => Operator::Subtraction,
                _ => unreachable! {},
            };
            let (lhs, rhs) = (expression_stack.pop_front(), expression_stack.pop_front());
            expression_stack.push_front(Expression::composed(lhs.unwrap(), operator, rhs.unwrap()));
        }
        expression_stack.pop_front().unwrap()
    }

    fn to_postfix(&self) -> String {
        match &self.expression_type {
            ExpressionType::Atomic(v) => v.to_string(),
            ExpressionType::Composed(lhs, op, rhs) => {
                let op = match op {
                    Operator::Addition => "+",
                    Operator::Subtraction => "-",
                };

                format!("{} {} {}", lhs.to_postfix(), rhs.to_postfix(), op)
            }
        }
    }
}

enum Operator {
    Addition,
    Subtraction,
}

enum ExpressionType {
    Atomic(u32),
    Composed(Box<Expression>, Operator, Box<Expression>),
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
