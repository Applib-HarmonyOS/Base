# Base

Base is a lightweight library that gives you a clean architecture foundation for your Harmony project.

[![icon](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)

The main objective of this repository is to show developers how I would architect my Harmony code in future projects.

## Installation tutorial

1 . For using Base modules in your sample application, add below dependencies to generate hap/har: Modify entry build.gradle as below :

```
      dependencies {
          implementation fileTree(dir: 'libs', include: ['*.jar','*.har'])
          implementation project(':base')
       }
```

2 . For using Base in separate application, add the below dependencies and include "base.har", in libs folder of "entry" module :

Modify entry build.gradle as below :

```
     dependencies {
         implementation fileTree(dir: 'libs', include: ['*.jar','*.har'])
     }
```

## License

```
Copyright 2011, 2012 Thiago Rocha

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```