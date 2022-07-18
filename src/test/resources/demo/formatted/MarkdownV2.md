*bold \*text*

_italic \*text_

__underline__

~strikethrough~

||spoiler||

*bold _italic bold ~italic bold strikethrough ||italic bold strikethrough spoiler||~ 

__underline italic bold___ bold*

[inline URL](http://www.example.com/)

[inline mention of a user](tg://user?id=185929241)

`inline fixed-width code`

```
pre-formatted fixed-width code block
```

```python
pre-formatted fixed-width code block written in the Python programming language
```

```java
package com.tutrit.telegram;

import com.tutrit.telegram.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramDemoBotApp {
	public static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);

	public static void main(String[] args) {
		SpringApplication.run(TelegramDemoBotApp.class, args);
	}
}
```