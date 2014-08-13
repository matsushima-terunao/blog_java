package jp.matsushima.spring_test.service;

import java.util.ArrayList;
import java.util.Collection;

import jp.matsushima.spring_test.dao.SetUpDao;
import jp.matsushima.spring_test.dao.UserDao;
import jp.matsushima.spring_test.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ユーザー情報サービス。
 * 
 * @author 2013/10/25 matsushima
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SetUpDao startUpDao;

	class MyUserDetails implements UserDetails {

		private static final long serialVersionUID = 1L;

		/** ユーザーマスタ。 */
		private User user;

		public MyUserDetails(User user) {
			super();
			System.out.println("MyUserDetails:"+user);
			this.user = user;
		}

		/**
		 * ユーザーマスタ。を取得します。
		 * @return ユーザーマスタ。
		 */
		public User getUser() {
		    return user;
		}

		/**
		 * ユーザーマスタ。を設定します。
		 * @param user ユーザーマスタ。
		 */
		public void setUser(User user) {
			System.out.println("setUser:"+user);
		    this.user = user;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			System.out.println("getAuthorities");
			ArrayList<GrantedAuthority> result = new ArrayList<>();
			result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			result.add(new SimpleGrantedAuthority("ROLE_USER"));
			return result;
		}

		@Override
		public String getPassword() {
			System.out.println("getPassword"+user);
			return user.getPassword();
		}

		@Override
		public String getUsername() {
			System.out.println("getUsername");
			return user.getLoginid();
		}

		@Override
		public boolean isAccountNonLocked() {
			System.out.println("isAccountNonLocked");
			return true;
		}

		@Override
		public boolean isEnabled() {
			System.out.println("isEnabled");
			return true;
		}

		@Override
		public boolean isAccountNonExpired() {
			System.out.println("isAccountNonExpired");
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			System.out.println("isCredentialsNonExpired");
			return true;
		}
	}

	/**
	 * ユーザー名からユーザー情報を取得。
	 * 
	 * @param username
	 * @return
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//startUpDao.setup();
		User user = userDao.selectByLoginid(username);
		return (null == user ? null : new MyUserDetails(user));
	}
}
