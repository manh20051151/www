# Lab Week05

## 1. Mô tả yêu cầu chức năng

### 1.1. Quản lý tài khoản
#### Nhà tuyển dụng:
- Đăng ký và xác thực tài khoản.
- Đăng nhập/đăng xuất.
- Cập nhật thông tin công ty (tên, địa chỉ, ngành nghề).

#### Ứng viên:
- Đăng ký và xác thực tài khoản.
- Đăng nhập/đăng xuất.
- Cập nhật thông tin cá nhân (họ tên, email, số điện thoại).
- Cập nhật danh sách kỹ năng.

### 1.2. Quản lý tin tuyển dụng (dành cho nhà tuyển dụng)
- Đăng tin tuyển dụng với đầy đủ thông tin: tiêu đề, mô tả, yêu cầu kỹ năng.
- Cập nhật hoặc xóa tin tuyển dụng.
- Tìm kiếm ứng viên có kỹ năng phù hợp với yêu cầu.
- Gửi email mời ứng tuyển và đánh dấu ứng viên đã được mời.

### 1.3. Gợi ý công việc phù hợp (dành cho ứng viên)
- Dựa trên kỹ năng của ứng viên, hiển thị danh sách công việc phù hợp.
- Gợi ý các kỹ năng chưa có mà ứng viên nên học.
- Hỗ trợ nộp đơn ứng tuyển qua email và đánh dấu công việc đã nộp đơn.

### 1.4. Gửi và quản lý email
#### Nhà tuyển dụng:
- Gửi email mời ứng tuyển đến ứng viên.
- Hiển thị danh sách ứng viên đã được mời.

#### Ứng viên:
- Gửi email nộp đơn đến nhà tuyển dụng.
- Hiển thị danh sách công việc đã nộp đơn.

### 1.5. Gợi ý kỹ năng học tập
- Dựa trên phân tích dữ liệu kỹ năng của ứng viên và yêu cầu của thị trường lao động, gợi ý các kỹ năng mới mà ứng viên có thể học để tăng cơ hội việc làm.

### 1.6. Giao diện chính

#### Nhà tuyển dụng:
- Giao diện hiển thị danh sách tin tuyển dụng và trạng thái của từng tin.
- Bộ lọc tìm kiếm ứng viên theo kỹ năng và vị trí.

#### Ứng viên:
- Giao diện hiển thị danh sách công việc phù hợp và trạng thái (đã nộp/đang mở).
- Giao diện quản lý và cập nhật danh sách kỹ năng.

---
## Class diagram
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/Class_diagram.png)
## 2. Các chức năng

### 2.1. Đăng ký tài khoản nhà tuyển dụng
Cho phép nhà tuyển dụng tạo tài khoản bằng cách cung cấp thông tin như: Username, Password, Company Name, About, Website URL, Email, Phone. Sau khi đăng ký, nhà tuyển dụng có thể sử dụng tài khoản để đăng tin tuyển dụng.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/danKy_company_1.gif)
### 2.2. Đăng ký tài khoản ứng viên
Ứng viên có thể tạo tài khoản bằng cách nhập các thông tin cá nhân như: Username, Password, Full Name, Date of Birth, Email, Phone. Tài khoản được dùng để tìm kiếm và ứng tuyển công việc phù hợp.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/dangKy_candidate_1.gif)
### 2.3. Đăng nhập
Nhà tuyển dụng và ứng viên đăng nhập vào hệ thống bằng username và mật khẩu đã đăng ký, cho phép truy cập các chức năng tương ứng.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/dang_nhap_1.gif)
### 2.4. Đăng xuất
Cung cấp tính năng đăng xuất để bảo mật tài khoản, đảm bảo người dùng không thể tiếp tục sử dụng tài khoản sau khi rời khỏi hệ thống.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/dangXuat_1.gif)
### 2.5. Xem, cập nhật thông tin cá nhân và skill của ứng viên
Ứng viên có thể xem và chỉnh sửa thông tin cá nhân như tên, email, số điện thoại và các kỹ năng. Cập nhật các kỹ năng mới giúp ứng viên nâng cao cơ hội ứng tuyển và tìm kiếm công việc phù hợp.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/xemCapNhatTTVaSkillCandidate1.gif)
### 2.6. Xem, cập nhật thông tin cá nhân của nhà tuyển dụng
Nhà tuyển dụng có thể xem và cập nhật thông tin công ty như tên, địa chỉ, email và số điện thoại, giúp đảm bảo thông tin liên lạc luôn chính xác và dễ dàng kết nối với ứng viên.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/xemCapNhatTTCompany1.gif)
### 2.7. Xem và gửi mail ứng tuyển những vị trí phù hợp
Ứng viên có thể xem các công việc phù hợp với kỹ năng của mình. Các kỹ năng thiếu sẽ được hiển thị bằng màu đỏ, trong khi các kỹ năng ứng viên đã có sẽ hiển thị bằng màu xanh lá. Ứng viên có thể chuyển giữa các tab "All" để xem tất cả các vị trí và "Suitable job" để chỉ xem các vị trí phù hợp. Khi tìm thấy công việc phù hợp, ứng viên có thể gửi email ứng tuyển đến nhà tuyển dụng. Các vị trí đã ứng tuyển sẽ hiển thị trạng thái "Applied/invited".
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/guiMailCandidate.gif)
### 2.8. Xem và gửi mail mời những ứng viên phù hợp
Nhà tuyển dụng có thể xem các công việc phù hợp với mình và các nhà tuyển dụng khác. Hệ thống sẽ hiển thị các ứng viên có kỹ năng phù hợp với yêu cầu công việc. Các kỹ năng ứng viên thiếu sẽ được hiển thị bằng màu đỏ, trong khi các kỹ năng ứng viên đã có sẽ hiển thị bằng màu xanh lá. Khi tìm thấy ứng viên phù hợp, nhà tuyển dụng có thể gửi email mời ứng viên. Các ứng viên đã nhận lời mời sẽ hiển thị trạng thái "Applied/invited".
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/guiMailCompany.gif)
### 2.9. Đăng tin tuyển dụng
Nhà tuyển dụng có thể đăng tin tuyển dụng mới, chỉ định các kỹ năng yêu cầu cho vị trí tuyển dụng, giúp ứng viên dễ dàng tìm thấy các công việc phù hợp.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/dangTin.gif)
### 2.10. Chỉnh sửa tin tuyển dụng
Nhà tuyển dụng có thể chỉnh sửa thông tin tin tuyển dụng đã đăng, bao gồm việc cập nhật mô tả công việc, kỹ năng yêu cầu, hoặc các thông tin khác liên quan đến công việc.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/suaTin1.gif)
### 2.11. Xóa tin tuyển dụng
Nhà tuyển dụng có thể xóa các tin tuyển dụng đã đăng khi không còn nhu cầu tuyển dụng cho vị trí đó.
![](https://github.com/manh20051151/www/blob/master/week05/week05_lab_NguyenVietManh_20051151/img/xoaTin.gif)
