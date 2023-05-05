import request from '@/utils/request'

// 查询用户测试列表
export function listTestUser(query) {
  return request({
    url: '/test/testUser/list',
    method: 'get',
    params: query
  })
}

// 查询用户测试详细
export function getTestUser(id) {
  return request({
    url: '/test/testUser/' + id,
    method: 'get'
  })
}

// 新增用户测试
export function addTestUser(data) {
  return request({
    url: '/test/testUser',
    method: 'post',
    data: data
  })
}

// 修改用户测试
export function updateTestUser(data) {
  return request({
    url: '/test/testUser',
    method: 'put',
    data: data
  })
}

// 删除用户测试
export function delTestUser(id) {
  return request({
    url: '/test/testUser/' + id,
    method: 'delete'
  })
}
