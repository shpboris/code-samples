package org.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
@AllArgsConstructor
public class User {
	@Id
	private String id;
	private String name;
}
