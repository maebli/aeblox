# Chapter 5: Representing code 


## 5.1: Syntatic Sugar

Challenge: get rid of syntactic sugar ?,+,*,|
```
expr -> expr ( "(" ( expr ( "," expr )* )? ")" | "." IDENTIFIER )+
        | IDENTIFIER
        | NUMBER
```

```
expr -> expr "("  arguments  ")" 
expr -> expr "(" ")" 
expr -> expr "." IDENTIFIER 
expr -> IDENTIFIER
expr -> NUMBER

arguments -> expr "," expr
arguments -> expr
```


## 5.2 The Visitor pattern in a functional language


[Article from Book's author Bob Nystrom.](https://journal.stuffwithstuff.com/2010/10/01/solving-the-expression-problem/)

First lets try in Rust. 

We need a function that selects the correct function given an object containing only data.
This will not work for foreign types because of the `orphan rule`.

``` rust

struct Croissant;
struct PainAuChocolate;

trait Pastry{
    fn bake(&self);
}

impl Pastry for Croissant {
    fn bake(&self){
        // bake
    }
}
impl Pastry for PainAuChocolate {
    fn bake(&self){
        // bake
    }
}

```

Like this we could put the bake methods into one file and have it at one place, which seems to solve the challenge.
The linked solution proposes using an algebraic data type that can be matched.

Rusts' enums are [Tagged union](https://en.wikipedia.org/wiki/Tagged_union)
```rust

enum Pastry{
    Croissant,
    PainAuChocolate
}

fn bake(pastry:Pastry){
    match pastry{
        Croissant => println!("bake croissant"),
        PainAuChocolate => println!("bake pain au chcolate)
    }
}

```

``` ocaml

type pastry = 
   | Croissant
   | PainAuChocolate

let bake pastry = 
   match pastry with 
   | Croissant -> print_endline "Baked croissant"
   | PainAuChocolate -> print_endline "Baked pain au chocolate"

let () =
  bake Croissant;
  bake PainAuChocolate

```

