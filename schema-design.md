## MySQL Database Design

### Table: patients
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- email: VARCHAR(255), Not Null
- password: VARCHAR(255), Not Null
- phone: VARCHAR(10), Not Null
- address: VARCHAR(255), Not Null

### Table: doctors
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- specialty: VARCHAR(50), Not Null
- email: VARCHAR(255), Not Null
- password: VARCHAR(255), Not Null
- phone: VARCHAR(10), Not Null
- available_times: TEXT (JSON array of available time slots)

### Table: admin
- id: BIGINT, Primary Key, Auto Increment
- username: VARCHAR(255), Not Null
- password: VARCHAR(255), Not Null

### Table: appointments
- id: BIGINT, Primary Key, Auto Increment
- doctor_id: BIGINT, Foreign Key -> doctors(id), Not Null
- patient_id: BIGINT, Foreign Key -> patients(id), Not Null
- appointment_time: DATETIME, Not Null
- status: INT, Not Null (0 = Scheduled, 1 = Completed, 2 = Cancelled)

### Table: clinic_locations
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(255), Not Null
- address: TEXT, Not Null
- phone: VARCHAR(20), Not Null
- operating_hours: VARCHAR(50)

### Table: payments
- id: BIGINT, Primary Key, Auto Increment
- appointment_id: BIGINT, Foreign Key -> appointments(id), Not Null
- patient_id: BIGINT, Foreign Key -> patients(id), Not Null
- amount: DECIMAL(10,2), Not Null
- payment_method: VARCHAR(50), Not Null
- payment_status: VARCHAR(20), Default 'Pending'
- transaction_date: DATETIME

## MongoDB Collection Design

### Collection: prescriptions

```json
{
  "_id": "ObjectId('64abc123456')",
  "patientName": "John Smith",
  "appointmentId": 51,
  "medication": "Paracetamol",
  "dosage": "500mg",
  "doctorNotes": "Take 1 tablet every 6 hours.",
  "refillCount": 2,
  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street"
  }
}
```

### Collection: feedback

```json
{
  "_id": "ObjectId('64def789012')",
  "appointmentId": 51,
  "patientId": 23,
  "doctorId": 7,
  "rating": 5,
  "comments": "Dr. Martinez was very professional and took time to explain my condition thoroughly. The clinic was clean and staff was friendly.",
  "categories": {
    "doctorProfessionalism": 5,
    "facilityClean": 5,
    "waitTime": 4,
    "staffCourtesy": 5
  },
  "recommendToOthers": true,
  "feedbackDate": "2024-11-15T14:30:00Z",
  "isAnonymous": false,
  "status": "approved"
}
```

### Collection: logs

```json
{
  "_id": "ObjectId('64ghi345678')",
  "timestamp": "2024-11-15T09:22:15Z",
  "level": "INFO",
  "userId": 23,
  "userType": "patient",
  "action": "appointment_booked",
  "resource": "appointments",
  "resourceId": 51,
  "details": {
    "appointmentTime": "2024-11-20T10:00:00Z",
    "doctorId": 7,
    "appointmentType": "consultation"
  },
  "sessionId": "sess_abc123xyz789",
  "success": true,
  "errorMessage": null
}
```

### Collection: messages

```json
{
  "_id": "ObjectId('64jkl901234')",
  "conversationId": "conv_patient23_doctor7",
  "senderId": 23,
  "senderType": "patient",
  "receiverId": 7,
  "receiverType": "doctor",
  "messageContent": "Hello Dr. Martinez, I wanted to follow up on the medication you prescribed. I've been taking it for 3 days but still experiencing some discomfort. Should I continue or contact you?",
  "messageType": "text",
  "appointmentReference": 51,
  "timestamp": "2024-11-18T16:45:00Z",
  "isRead": false,
  "isUrgent": false,
  "attachments": [],
  "metadata": {
    "messageLength": 187,
    "language": "en",
    "sentiment": "concerned"
  },
  "status": "delivered"
}
```