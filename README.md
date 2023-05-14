# InstaAPI-weekly-test
The model for the backend of Instagram includes two main entities: User and Post.

User: This entity represents a user of the Instagram platform. It includes the following attributes:

firstName: The first name of the user.
lastName: The last name of the user.
age: The age of the user.
email: The email address of the user.
phoneNumber: The phone number of the user.
The User entity also utilizes authentication during sign-in and sign-up processes, where a token is received and used for all subsequent user operations.
Post: This entity represents a post on Instagram. It includes the following attributes:

postId: A unique identifier for the post.
createdDate: The timestamp indicating when the post was created.
updatedDate: The timestamp indicating when the post was last updated.
postData: A dummy string placeholder (e.g., "abcd") that will be replaced by the image link string in the implementation. This represents the content of the post, such as an image or video.
In addition, the Post entity has a Many-to-One relationship with the User entity, indicating that multiple posts can belong to a single user. This relationship is represented by the @ManyToOne annotation, with lazy fetching enabled.

Overall, the model provides the necessary structure to represent users and their associated posts on the Instagram platform, enabling authentication, user information, and post data management.
