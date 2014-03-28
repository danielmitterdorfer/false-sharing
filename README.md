False Sharing
=============

This is a small demo project for the accompanying blog post [False Sharing](http://daniel.mitterdorfer.name/articles/2014/false-sharing/). It contains a microbenchmark to demonstrate the effects of false sharing and its mitigation with `@Contended`.

# Getting Started

## Prerequisites

The project requires at least JDK 8 and Gradle 1.8.

## Installation and Usage

```
git clone https://github.com/danielmitterdorfer/false-sharing.git
cd false-sharing
gradle shadow
java -jar build/distributions/false-sharing-0.1.0-shadow.jar -rf csv -rff false-sharing.csv


# License

'False Sharing' is distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).