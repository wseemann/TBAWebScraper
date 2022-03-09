# TBAWebScraper


TBAWebScraper
============================

Overview
--------

A Java based web scraper to extract tournament data from http://www.tbasanctioning.org/


Usage
------------

Sample code:

##### Retrieve all tounament brackets and registered athletes

    TBAWebScraper tbaWebScraper = new TBAWebScraper();
    List<BracketWithCompetitors> bracketWithCompetitorsList = tbaWebScraper.scrape();


License
------------

```
TBAWebScraper: A Java based web scraper to extract tournament data from http://www.tbasanctioning.org/

Copyright 2022 William Seemann

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
