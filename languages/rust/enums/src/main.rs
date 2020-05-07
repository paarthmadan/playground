enum VehicleKind {
    Motorcycle,
    Automobile,
}

struct Vehicle {
    kind: VehicleKind,
    name: String,
}

enum IpAddr {
    V4(u8, u8, u8, u8),
    V6(String),
}

fn main() {
    let blue_bike = Vehicle {
        name: String::from("Blue Bike"),
        kind: VehicleKind::Motorcycle,
    };

    let red_car = Vehicle {
        name: String::from("Red Car"),
        kind: VehicleKind::Automobile,
    };

    drive(blue_bike);
    drive(red_car);

    let home = IpAddr::V4(127, 0, 0, 1);
    let loopback = IpAddr::V6(String::from("::1"));

    let some = Some(1);

    if let Some(u8) = some {
        println!("unwrapped");
    } 
}

fn drive(vehicle: Vehicle) {
    match vehicle.kind {
        VehicleKind::Motorcycle => println!("Skrting in my {}", vehicle.name),
        VehicleKind::Automobile => println!("Vrooming in my {}", vehicle.name),
    }
}
