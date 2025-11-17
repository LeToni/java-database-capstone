# Admin User Stories

## US-001: Admin Portal Login
**Title:**
_As an admin, I want to log into the portal with my username and password, so that I can manage the platform securely._

**Acceptance Criteria:**
1. Admin can enter username and password on a secure login form
2. System validates credentials against the admin user database
3. Successful login redirects admin to the admin dashboard
4. Failed login attempts display appropriate error messages
5. Login session is established with proper security tokens

**Priority:** High
**Story Points:** 3
**Notes:**
- Implement password encryption and secure authentication
- Consider implementing login attempt limits for security
- Ensure HTTPS is used for login requests

---

## US-002: Admin Portal Logout
**Title:**
_As an admin, I want to log out of the portal, so that I can protect system access when I'm finished working._

**Acceptance Criteria:**
1. Admin can click a logout button/link from any page in the admin portal
2. System immediately invalidates the admin's session
3. Admin is redirected to the login page after logout
4. All cached admin data is cleared from the browser
5. Attempting to access admin pages after logout requires re-authentication

**Priority:** High
**Story Points:** 2
**Notes:**
- Implement automatic session timeout for security
- Clear all sensitive data from client-side storage on logout

---

## US-003: Add Doctor to Portal
**Title:**
_As an admin, I want to add doctors to the portal, so that they can provide medical services through the platform._

**Acceptance Criteria:**
1. Admin can access a "Add Doctor" form from the admin dashboard
2. Form includes fields for doctor's personal information (name, email, phone, address)
3. Form includes fields for professional information (specialization, license number, qualifications)
4. System validates all required fields before submission
5. New doctor profile is created in the MySQL database
6. Doctor receives login credentials via secure email
7. Success confirmation is displayed to admin upon completion

**Priority:** High
**Story Points:** 5
**Notes:**
- Implement email validation for doctor's email address
- Generate secure temporary password for new doctors
- Consider adding photo upload functionality for doctor profiles

---

## US-004: Delete Doctor Profile
**Title:**
_As an admin, I want to delete a doctor's profile from the portal, so that I can remove doctors who are no longer providing services._

**Acceptance Criteria:**
1. Admin can search and select a doctor from the doctor management interface
2. Admin can click a "Delete" button on the selected doctor's profile
3. System displays a confirmation dialog before proceeding with deletion
4. Upon confirmation, doctor's profile is removed from the MySQL database
5. All associated appointment data is handled appropriately (archived or reassigned)
6. Doctor's login access is immediately revoked
7. Success message is displayed confirming the deletion

**Priority:** Medium
**Story Points:** 4
**Notes:**
- Implement soft delete to preserve historical data if needed
- Handle existing appointments when deleting doctor profiles
- Consider adding a deactivation option instead of permanent deletion

---

## US-005: Monthly Appointment Statistics
**Title:**
_As an admin, I want to run a stored procedure in MySQL CLI to get the number of appointments per month, so that I can track usage statistics and monitor platform performance._

**Acceptance Criteria:**
1. Admin can access MySQL CLI through the admin portal or direct database connection
2. Stored procedure `GetMonthlyAppointmentStats` is available and executable
3. Procedure returns appointment counts grouped by month for the current year
4. Results include month name, year, and total appointment count
5. Admin can export results to CSV format for further analysis
6. Procedure executes within acceptable performance timeframes
7. Results are formatted in a readable table structure

**Priority:** Medium
**Story Points:** 3
**Notes:**
- Stored procedure should follow the template provided in the project files
- Consider adding filters for date ranges and doctor-specific statistics
- Implement proper error handling for database connectivity issues
- Results should include both completed and cancelled appointments for comprehensive tracking

---

# Patient User Stories

## US-006: Browse Doctors Without Login
**Title:**
_As a prospective patient, I want to view a list of doctors without logging in, so that I can explore options before registering._

**Acceptance Criteria:**
1. Homepage displays a searchable list of available doctors
2. Doctor profiles show basic information (name, specialization, experience)
3. Users can filter doctors by specialization, location, or availability
4. Doctor profile pages are accessible without authentication
5. Clear call-to-action prompts users to register for booking appointments
6. Page loads quickly and is mobile-responsive

**Priority:** High
**Story Points:** 3
**Notes:**
- Limit information displayed to non-sensitive data only
- Include doctor ratings/reviews if available
- Implement SEO-friendly URLs for better search engine visibility

---

## US-007: Patient Registration
**Title:**
_As a new patient, I want to sign up using my email and password, so that I can book appointments with doctors._

**Acceptance Criteria:**
1. Registration form includes fields for email, password, and basic personal information
2. System validates email format and checks for existing accounts
3. Password requirements are clearly displayed and enforced
4. Email verification is sent to confirm account activation
5. User profile is created in the MySQL database upon successful registration
6. New users are redirected to a welcome page with next steps
7. Privacy policy and terms of service are presented and accepted

**Priority:** High
**Story Points:** 5
**Notes:**
- Implement strong password requirements (minimum length, special characters)
- Add CAPTCHA to prevent automated registrations
- Consider social login options (Google, Facebook) for convenience

---

## US-008: Patient Portal Login
**Title:**
_As a registered patient, I want to log into the portal, so that I can manage my bookings and access my health information._

**Acceptance Criteria:**
1. Login form accepts email and password credentials
2. System authenticates against patient database records
3. Successful login redirects to patient dashboard
4. Failed attempts show appropriate error messages
5. "Remember me" option for trusted devices
6. "Forgot password" link for account recovery
7. Session management with appropriate timeout settings

**Priority:** High
**Story Points:** 3
**Notes:**
- Implement account lockout after multiple failed attempts
- Add two-factor authentication option for enhanced security
- Ensure mobile-friendly login experience

---

## US-009: Patient Portal Logout
**Title:**
_As a logged-in patient, I want to log out of the portal, so that I can secure my account when finished._

**Acceptance Criteria:**
1. Logout button/link is visible on all authenticated pages
2. Clicking logout immediately terminates the user session
3. User is redirected to the homepage or login page
4. All patient data is cleared from browser cache/storage
5. Confirmation message indicates successful logout
6. Attempting to access protected pages requires re-authentication

**Priority:** High
**Story Points:** 2
**Notes:**
- Implement automatic logout after period of inactivity
- Clear sensitive data from browser memory on logout
- Consider warning users before automatic logout

---

## US-010: Book Hour-Long Appointment
**Title:**
_As a logged-in patient, I want to book an hour-long appointment, so that I can consult with a doctor about my health concerns._

**Acceptance Criteria:**
1. Patient can search and select from available doctors
2. Calendar interface shows doctor's available time slots
3. System displays only hour-long appointment slots
4. Patient can select preferred date and time
5. Appointment booking form includes reason for visit and special requirements
6. Confirmation email is sent to patient after successful booking
7. Appointment is saved in MySQL database with all relevant details
8. Doctor's availability is updated to reflect the booked slot

**Priority:** High
**Story Points:** 8
**Notes:**
- Implement real-time availability checking to prevent double bookings
- Add appointment reminder notifications
- Consider payment integration if required
- Include appointment cancellation/rescheduling options

---

## US-011: View Upcoming Appointments
**Title:**
_As a logged-in patient, I want to view my upcoming appointments, so that I can prepare accordingly and manage my schedule._

**Acceptance Criteria:**
1. Patient dashboard displays a list of upcoming appointments
2. Each appointment shows date, time, doctor name, and specialization
3. Appointments are sorted by date and time (earliest first)
4. Patient can view appointment details including reason for visit
5. Options to reschedule or cancel appointments are available
6. Calendar view option for better schedule visualization
7. Past appointments are accessible in a separate history section

**Priority:** High
**Story Points:** 4
**Notes:**
- Include countdown timer for next appointment
- Add integration with external calendar apps (Google Calendar, Outlook)
- Implement push notifications for appointment reminders
- Show preparation instructions for specific appointment types

---

# Doctor User Stories

## US-012: Doctor Portal Login
**Title:**
_As a doctor, I want to log into the portal, so that I can manage my appointments and access patient information securely._

**Acceptance Criteria:**
1. Doctor can enter credentials (email/username and password) on a secure login form
2. System authenticates against doctor database records
3. Successful login redirects doctor to the doctor dashboard
4. Failed login attempts display clear error messages
5. Session is established with appropriate security tokens
6. Multi-factor authentication option is available for enhanced security
7. Login activity is logged for audit purposes

**Priority:** High
**Story Points:** 3
**Notes:**
- Implement role-based access control for doctor-specific features
- Add professional license verification during login process
- Ensure HIPAA-compliant session management

---

## US-013: Doctor Portal Logout
**Title:**
_As a doctor, I want to log out of the portal, so that I can protect my data and patient information when I'm finished working._

**Acceptance Criteria:**
1. Logout button is prominently displayed on all doctor portal pages
2. Clicking logout immediately terminates the doctor's session
3. All cached patient data is cleared from the browser
4. Doctor is redirected to a secure logout confirmation page
5. Any unsaved changes are handled appropriately (save prompt or auto-save)
6. Session timeout occurs automatically after period of inactivity
7. Logout action is logged for security audit trail

**Priority:** High
**Story Points:** 2
**Notes:**
- Implement automatic logout for HIPAA compliance
- Clear sensitive patient data from all browser storage
- Add warning before automatic logout to prevent data loss

---

## US-014: View Appointment Calendar
**Title:**
_As a doctor, I want to view my appointment calendar, so that I can stay organized and manage my schedule effectively._

**Acceptance Criteria:**
1. Calendar interface displays appointments in daily, weekly, and monthly views
2. Each appointment shows patient name, time, duration, and appointment type
3. Calendar is color-coded by appointment status (confirmed, pending, completed)
4. Doctor can navigate between different dates and time periods
5. Current date and time are clearly highlighted
6. Calendar integrates with doctor's availability settings
7. Export options available for external calendar applications

**Priority:** High
**Story Points:** 5
**Notes:**
- Implement real-time updates for schedule changes
- Add drag-and-drop functionality for rescheduling
- Include conflict detection for overlapping appointments
- Consider mobile-responsive calendar design

---

## US-015: Mark Unavailability
**Title:**
_As a doctor, I want to mark my unavailability, so that patients can only see and book my available time slots._

**Acceptance Criteria:**
1. Doctor can access availability management from the dashboard
2. Interface allows setting unavailable dates and time ranges
3. Recurring unavailability patterns can be set (weekly, monthly)
4. Reasons for unavailability can be specified (vacation, conference, personal)
5. Unavailable slots are immediately hidden from patient booking system
6. Doctor can modify or remove previously set unavailable periods
7. System prevents booking conflicts during unavailable times

**Priority:** High
**Story Points:** 6
**Notes:**
- Implement advance notice requirements for availability changes
- Add approval workflow for extended unavailability periods
- Consider emergency override options for urgent appointments
- Integrate with existing appointment scheduling system

---

## US-016: Update Doctor Profile
**Title:**
_As a doctor, I want to update my profile with specialization and contact information, so that patients have up-to-date information about my services._

**Acceptance Criteria:**
1. Profile editing form is accessible from doctor dashboard
2. Form includes fields for specializations, qualifications, and certifications
3. Contact information fields include phone, email, and office location
4. Professional biography and photo can be updated
5. System validates all required fields before saving changes
6. Changes are immediately reflected in patient-facing doctor listings
7. Profile update history is maintained for administrative purposes

**Priority:** Medium
**Story Points:** 4
**Notes:**
- Implement approval workflow for certain profile changes
- Add photo upload with size and format restrictions
- Include verification process for new specializations or certifications
- Ensure patient privacy in contact information display

---

## US-017: View Patient Details for Appointments
**Title:**
_As a doctor, I want to view patient details for upcoming appointments, so that I can be prepared and provide better care._

**Acceptance Criteria:**
1. Doctor can access patient information from appointment calendar or dashboard
2. Patient details include contact information, medical history, and previous visits
3. Current medications and known allergies are prominently displayed
4. Reason for current appointment and any special notes are visible
5. Previous appointment notes and prescriptions are accessible
6. Patient information is presented in a clear, organized format
7. Access to patient data is logged for HIPAA compliance

**Priority:** High
**Story Points:** 6
**Notes:**
- Implement role-based access to patient information
- Add quick access to relevant medical records and test results
- Include patient photo for identification if available
- Ensure all patient data access complies with privacy regulations
- Add functionality to add pre-appointment notes or preparations