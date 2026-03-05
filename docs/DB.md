# Database definition

## Users table

### Columns
- ID: VARCHAR (PrimaryKey)
- Name: VARCHAR
- Hash(Password): VARCHAR
- Email: VARCHAR
- Year: INTEGER
- Genre: VARCHAR

## CycleEvents table

### Columns
- ID: VARCHAR (PrimaryKey)
- EventType: VARCHAR
- Date: DATE
- AuthorID: VARCHAR (ForeignKey)
- UserID: VARCHAR (ForeignKey)

### Relations
- AuthorID -> Users::ID (n-1)
- UserID -> Users::ID (n-1)

### Indexes
- EventType
- Date
- UserID

## Permissions table

### Columns
- TargetUserID: VARCHAR (PrimaryKey)
- UserID: VARCHAR (PrimaryKey)
- Write: BOOL
- Read: BOOL

### Relations
- TargetUserID -> Users::ID (n-1)
- UserID -> Users::ID (n-1)

### Indexes
- TargetUserID
- UserID