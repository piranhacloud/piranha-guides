
# Piranha GraalVM Hello World template

This project delivers you with a template to get started with Piranha and
GraalVM.

## Building locally

To build the project locally use the following Maven command line:

```shell
  mvn clean install
```

## Docker image with GraalVM binary

### Create a Docker image with a GraalVM binary

If you want to deploy a GraalVM binary using a Docker image you can execute
the following command line:

```shell
  docker build -t graalvm -f Dockerfile .
```

This will create a Docker image named `graalvm` you can then push to a Docker
registry or execute locally using Docker

### Execute the Docker image with a GraalVM binary

Once you have completed the previous section executing the Docker image is as
simple as the command line below.

```shell
  docker run --rm -it -p 8080:8080 graalvm
```

And then browse to `http://localhost:8080/helloworld/index.html` to see it in
action.
