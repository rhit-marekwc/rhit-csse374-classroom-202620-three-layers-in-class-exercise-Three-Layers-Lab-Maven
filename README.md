# Three Layers Lab Exercise

## Building/Testing

Most _modern_ IDEs (IntelliJ IDEA, VS Code w/ Java Extension Pack) should immediately recognize this as a Maven project,
and determine how to build the project and run unit tests. You can also use the Maven CLI to execute "lifecycle" commands
that perform the same operations as the IDE. The important ones are:
 
- **Clean Build directory**: "clean" (`mvn clean`)
- **Build Source**: "compile" (`mvn compile`)
- **Run Tests**: "test" (`mvn test`)

You can learn more about the Maven lifecycle by reading the [Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

## Running the Main Class

To run the main PetMain class:

**Using Java directly (after compiling):**
```
java -cp target/classes oldsrc.PetMain
```

**Using your IDE:**
- Right-click on `PetMain.java` and select "Run" or "Run Java"
- Or run the `main` method directly from the editor

Note: The program reads pet data from `pets.txt` in the root directory, so ensure this file exists before running.

# Tasks

## Step 1: Add a presentation Layer

Don't worry about the external system packages yet.

Let PetMain be the presentation layer class.  Pull any console input or output into PetMain.  
Note this will require you to change the way some methods work.

## Step 2: Add a data layer

Currently the only data operation we do is load pets from a file.  PetMain being in the presentation layer, let's move this elsewhere.  Figure out a good place for it to live and move it there.

In terms of classes in the Data layer, it would be OK if the only class is the built in Java stream.  Or you can add your own class in there.

## Step 3: More data

Imagine for zoo audit purposes, we need to log to a datafile every time a pet is fed or exercised.  Lets say that using a pets
"special ability" counts as exercise.

This makes us want to use PetAuditRecord and PetAuditSystem in the Data Layer.  Add those in to the Animal code which should be fairly easy because the domain layer can freely depend on them.

## Step 4: Still More Data

Now imagine that some external zoo regulatory agency wants to ensure the animals are reliably fed.  As a result they have
a service ExternalPetAuditService that needs to be called when the animals are fed.  

As an additional complication these calls require the animals id number assigned by the regulator, not their name which is used for zoo operations.  We have a mapping of one to the other, but we would prefer not to pollute the animal class with
this information.

We could just augment the animals feeding methods further, but at this point we think that we might want to introduce
greater abstraction in the Data Layer so that all our auditing constraints can be handled at that layer.  Using UML
or code, propose a solution that still does not introduce an inappropiate dependence.