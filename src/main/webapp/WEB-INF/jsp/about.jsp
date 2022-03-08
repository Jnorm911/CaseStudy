<jsp:include page="include/header.jsp"/>
<div id="formBin">
    <div class="formCol">
        <div class="formBin">
            <div class="about">
                <h1>Lorem Ipsum</h1>
                <img src="https://placebear.com/620/800" alt="">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                    et dolore magna aliqua. Quis commodo odio aenean sed adipiscing diam donec adipiscing. Non
                    consectetur a erat nam at lectus urna duis convallis. Facilisis magna etiam tempor orci eu lobortis
                    elementum. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Tincidunt ornare
                    massa eget egestas purus. Arcu felis bibendum ut tristique et egestas quis ipsum. Nunc sed id semper
                    risus in hendrerit gravida rutrum quisque. Nunc eget lorem dolor sed viverra ipsum nunc. Dui nunc
                    mattis enim ut. Elit scelerisque mauris pellentesque pulvinar pellentesque. Tincidunt id aliquet
                    risus feugiat in ante. Volutpat lacus laoreet non curabitur gravida arcu ac tortor dignissim.
                    Facilisi cras fermentum odio eu feugiat pretium. Enim sed faucibus turpis in eu mi bibendum.</p>
            </div>
        </div>
        <div class="formBin">
            <h2 id="contact">Contact</h2>
            <form class="contactForm" action="#" method="post">
                <div class="contact">
                    <i class="fa fa-user icon"></i>
                    <input type="text" class="contactInput" name="visitor_name" placeholder="Name"
                           pattern=[A-Z\sa-z]{3,20} required>
                </div>
                <div class="contact">
                    <i class="fa fa-envelope icon"></i>
                    <input type="email" class="contactInput" name="visitor_email" placeholder="Email" required>
                </div>
                <div class="contact">
                    <i class="fas fa-book icon"></i>
                    <input type="text" class="contactInput" name="email_title" placeholder="Subject">
                </div>
                <div class="contact">
                    <i class="fas fa-comment icon"></i>
                    <textarea class="contactInput" name="visitor_message" placeholder="Message" required></textarea>
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>