[![Build](https://github.com/applibgroup/MaterialCalendar/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/MaterialCalendar/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_Base&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_Base)
[![license](https://img.shields.io/github/license/applibgroup/Base?color=blue)](LICENSE)
![1.0.0](https://img.shields.io/badge/version-1.0.0-blue.svg)

# Base

Base is a lightweight library that gives you a clean architecture foundation for your Harmony project.

[![icon](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)

The main objective of this repository is to show developers how I would architect my Harmony code in future projects.

### Source

This library has been inspired by [thiagokimo](https://github.com/thiagokimo)/**[Base](https://github.com/thiagokimo/Base)**.

### Integration
---
**Maven**

```xml
<dependency>
  <groupId>dev.applibgroup</groupId>
  <artifactId>base</artifactId>
  <version>1.0.0</version>
  <type>har</type>
</dependency>
```

```groovy
implementation 'dev.applibgroup:base:1.0.0'
```
**From Source**

1. For using Base module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.

      ```groovy
         implementation project(path: ':base')
      ```

2. For using Base module in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.

   ```groovy
      implementation fileTree(dir: 'libs', include: ['*.har'])
   ```

### Usages
---
implement callback interfaces:
```java
public class StudentDetailAbility extends BaseAbility<StudentDetailPresenter> implements StudentDetailContract.Component {
```

Then implement updateImage(String someUrl) method:

```java
 @Override
    public void updateImage(String someUrl) {
        Picasso.get()
                .load(someUrl)
                .placeholder(ResourceTable.Media_Jellyfish)
                .error(ResourceTable.Media_Jellyfish)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(mImage);
    }
```

set the updated name, text course...

```java
@Override
    public void updateName(String someName) {
        mTitle.setText(someName);
    }

    @Override
    public void updateDescription(String someDescription) {
        mDescription.setText(someDescription);
    }

    @Override
    public void updateCourse(String someCourse) {
        mSubtitle.setText(someCourse);
    }

    @Override
    public int getLayoutResource() {
        return ResourceTable.Layout_ability_detail;
    }

    @Override
    public void configureUI() {}

    @Override
    public StudentDetailPresenter injectDependencies() {
        Student student = mIntent.getSerializableParam(STUDENT);

        return new StudentDetailPresenter(this, student);
    }
```

Take a look at the [sample project](entry) for more information.

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