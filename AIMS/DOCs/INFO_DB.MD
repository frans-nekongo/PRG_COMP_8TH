### 1. Alumni Table:

This table stores information about alumni, including their contact details, academic history, and work-related information.

- AlumniID (Primary Key)
- First Name
- Last Name
- Student ID
- Cell Phone Number
- Email
- Faculty
- Department Graduated From
- Year of Graduation
- Final Grade
- Position Held in Class or School
- Home Address
- Office Address
- Next of Kin
### 2. Meetings Table:

This table is for managing alumni meetings and events.

- MeetingID (Primary Key)
- Meeting Title
- Meeting Date
- Meeting Description
- Meeting Location
- Organizer
- Attendees (can be a list of AlumniIDs)
### 3. Elections Table:

This table manages elections of alumni executive members.

- ElectionID (Primary Key)
- Election Title
- Election Date
- Candidates (references AlumniIDs)
- Winners (references AlumniIDs)
### 4. Payments Table:

This table tracks alumni dues, income, and expenditure.

- PaymentID (Primary Key)
- AlumniID (references AlumniIDs)
- Payment Date
- Payment Amount
- Transaction Type (Dues, Gift, Profit Sharing, etc.)
### 5. Jobs Table:

This table stores job and internship opportunities.

- JobID (Primary Key)
- Job Title
- Company Name
- Job Description
- Job Location
- Application Deadline
- Contact Email
- Contact Phone
6. News Table:

This table contains news and updates posted by companies and alumni.

NewsID (Primary Key)
News Title
News Content
Posting Date
Author (references AlumniIDs)
7. Messages Table:

This table handles messages and notifications.

MessageID (Primary Key)
Sender (references AlumniIDs)
Recipient (references AlumniIDs)
Message Content
Message Type (e.g., Chat, Notification)
8. Directory Table:

This table allows for searchable alumni profiles.

AlumniID (Primary Key, references AlumniIDs)
Name (Combined First Name and Last Name)
Year of Graduation
Student Number
9. Career Advice Table:

This table stores career advice content.

AdviceID (Primary Key)
Title
Content
Author (references AlumniIDs)
10. Photo Gallery Table:

This table stores photos and albums.

PhotoID (Primary Key)
Title
Description
AlbumID (if organizing photos into albums)
Image URL